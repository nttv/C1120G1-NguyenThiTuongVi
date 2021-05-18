import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Supervisor} from "../../models/supervisor";
import {Group} from "../../models/group";
import {StudentService} from "../../services/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  createForm: FormGroup;
  groups: Group[] = [];
  supervisors: Supervisor[] = [];

  constructor(private _formBuilder: FormBuilder,
              private _studentService: StudentService,
              private _router: Router) {
  }

  ngOnInit(): void {
    this.initForm();
    this.initData();
  }

  initData() {
    this._studentService.getGroups().subscribe(data => {
      this.groups = data;
    }, error => {
      console.log("getGroups() error: " + error);
    });

    this._studentService.getSupervisors().subscribe(data => {
      this.supervisors = data;
    }, error => {
      console.log("getSupervisors() error: " + error);
    });
  }

  initForm() {
    this.createForm = this._formBuilder.group({
      studentName: ['', [Validators.required, Validators.pattern("^[A-Za-z0-9\\s]+$")]],
      group: ['', Validators.required],
      topic: ['', Validators.required],
      supervisor: ['', Validators.required],
      email: ['', [Validators.required, Validators.pattern("^[A-Za-z0-9]+((_|\\.)?[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,3}$")]],
      phone: ['', [Validators.required, Validators.pattern("^\\d{10,12}$")]],
    });
  }

  create() {
    if (this.createForm.valid) {
      console.log(this.createForm.value);
      this._studentService.create(this.createForm.value).subscribe(() => {
        this._router.navigateByUrl('');
      }, error => {
        console.log('create() error: ' + error);
      });
    }
  }
}
