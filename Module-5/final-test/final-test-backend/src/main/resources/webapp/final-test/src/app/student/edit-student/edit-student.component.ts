import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StudentService} from "../../services/student.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Group} from "../../models/group";
import {Supervisor} from "../../models/supervisor";
import {Student} from "../../models/student";
import {forkJoin} from "rxjs";

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {

  updateForm: FormGroup;
  groups: Group[] = [];
  supervisors: Supervisor[] = [];
  updateStudent: Student;
  id: number = 0;

  constructor(private _studentService: StudentService,
              private _router: Router,
              private _formBuilder: FormBuilder,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    console.log("Step 1");  // test async
    this.initForm();
    this.initData();
  }

  initForm() {
    console.log("Step 2");  // test async
    this.updateForm = this._formBuilder.group({
      studentName: ['', [Validators.required, Validators.pattern("^[A-Za-z0-9\\s]+$")]],
      group: ['', Validators.required],
      topic: ['', Validators.required],
      supervisor: ['', Validators.required],
      email: ['', [Validators.required, Validators.pattern("^[A-Za-z0-9]+((_|\\.)?[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,3}$")]],
      phone: ['', [Validators.required, Validators.pattern("^\\d{10,12}$")]],
    });
  }

  initData() {
    this.id = this._activatedRoute.snapshot.params['id'];
    console.log("Step 3");  // test async

    const dataSource = [
      this._studentService.getGroups(),
      this._studentService.getSupervisors(),
      this._studentService.getById(this.id)
    ];

    forkJoin(dataSource).subscribe(data => {
      console.log("Step 4");  // test async
      // @ts-ignore
      this.groups = data[0];
      // @ts-ignore
      this.supervisors = data[1];
      // @ts-ignore
      this.updateStudent = data[2];
      this.patchFormValue();
    });
  }

  patchFormValue() {
    console.log("Step 5");  // test async
    this.updateForm.patchValue(this.updateStudent);
    let patchGroup = this.groups.find(obj => obj.groupId == this.updateStudent.group.groupId);
    let patchSupervisor = this.supervisors.find(obj =>
      obj.supervisorId == this.updateStudent.supervisor.supervisorId
    );
    this.updateForm.patchValue({
      group: patchGroup,
      supervisor: patchSupervisor
    });
  }

  update() {
    if (this.updateForm.valid) {
      console.log(this.updateForm.value);
      this._studentService.update(this.updateForm.value, this.id).subscribe(() => {
        this._router.navigateByUrl('');
      }, error => {
        console.log('update() error: ' + error);
      });
    }
  }

}
