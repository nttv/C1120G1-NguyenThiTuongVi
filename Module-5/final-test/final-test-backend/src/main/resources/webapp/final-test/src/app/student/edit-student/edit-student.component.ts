import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StudentService} from "../../services/student.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Group} from "../../models/group";
import {Supervisor} from "../../models/supervisor";
import {Student} from "../../models/student";
import {element} from "protractor";
import {forkJoin, Observable} from "rxjs";

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
    console.log("Step 1");  // test async
  }

  ngOnInit(): void {
    console.log("Step 2");  // test async
    this.initForm();
    this.initData().subscribe(() => {
      this.patchFormValue();
    });
  }

  initForm() {
    console.log("Step 3");  // test async
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
    const data$ = forkJoin(
      this._studentService.getGroups(),
      this._studentService.getSupervisors(),
      this._studentService.getById(this.id)
    );

    this.id = this._activatedRoute.snapshot.params['id'];
    console.log("Step 4");  // test async

    this._studentService.getGroups().subscribe(data => {
      console.log("Step 5");  // test async
      this.groups = data;
    }, error => {
      console.log("getGroups() error: " + error);
    });

    this._studentService.getSupervisors().subscribe(data => {
      console.log("Step 6");  // test async
      this.supervisors = data;
    }, error => {
      console.log("getSupervisors() error: " + error);
    });

    this._studentService.getById(this.id).subscribe(data => {
      console.log("Step 7");  // test async
      this.updateStudent = data;
    }, error => {
      console.log('getById(): ' + error);
    });

    this.patchFormValue();
  }

  patchFormValue() {
    console.log("Step 8");
    // this.updateForm.patchValue(this.updateStudent);
    let group = this.groups.find(obj => obj.groupId == this.updateStudent.group.groupId);
    console.log(group);
    console.log(this.updateStudent.group);


  }

  update() {
    if (this.updateForm.valid) {
      console.log(this.updateForm.value);
      console.log(this.updateForm.controls.group.value.groupId);
      // this._studentService.update(this.updateForm.value, this.id).subscribe(() => {
      //   this._router.navigateByUrl('');
      // }, error => {
      //   console.log('update(): ' + error);
      // });
    }
  }

}
