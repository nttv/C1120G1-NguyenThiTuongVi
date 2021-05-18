import {Component, OnInit} from '@angular/core';
import {Student} from "../../models/student";
import {StudentService} from "../../services/student.service";

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {

  students: Student[] = [];

  constructor(private _studentService: StudentService) {
  }

  ngOnInit(): void {
    this.initData();
  }

  initData() {
    this._studentService.getAll().subscribe(data => {
      this.students = data;
    }, error => {
      console.log('getAll() error: ' + error);
    });
  }
}
