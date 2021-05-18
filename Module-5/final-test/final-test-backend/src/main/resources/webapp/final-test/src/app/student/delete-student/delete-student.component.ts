import {Component, Inject, OnInit} from '@angular/core';
import {StudentService} from "../../services/student.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Student} from "../../models/student";

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent implements OnInit {

  student: Student;
  id: number;

  constructor(private _studentService: StudentService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.initData();
  }

  initData() {
    let id = this._activatedRoute.snapshot.params['id'];
    this.id = +id;
    this._studentService.getById(id).subscribe(data => {
      this.student = data;
    });
  }

  delete() {
    this._studentService.delete(this.id).subscribe(() => {
      console.log('abc');
      this._router.navigateByUrl('');
    });
  }
}
