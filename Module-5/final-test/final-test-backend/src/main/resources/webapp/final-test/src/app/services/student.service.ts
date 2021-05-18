import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../models/student";
import {Group} from "../models/group";
import {Supervisor} from "../models/supervisor";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private _API_URL_GROUPS = 'http://localhost:8080/groups';
  private _API_URL_SUPERVISORS = 'http://localhost:8080/supervisors';
  private _API_URL_STUDENTS = 'http://localhost:8080/students';

  constructor(private _httpClient: HttpClient) {
  }

  getGroups(): Observable<Group[]> {
    console.log("get groups");  // test async
    return this._httpClient.get<Group[]>(this._API_URL_GROUPS);
  }

  getSupervisors(): Observable<Supervisor[]> {
    console.log("get supervisors");  // test async
    return this._httpClient.get<Supervisor[]>(this._API_URL_SUPERVISORS);
  }

  getAll(): Observable<Student[]> {
    console.log("get students");  // test async
    return this._httpClient.get<Student[]>(this._API_URL_STUDENTS);
  }

  getById(id: number): Observable<Student> {
    console.log("get student by id");  // test async
    return this._httpClient.get<Student>(`${this._API_URL_STUDENTS}/${id}`);
  }

  create(student: Student): Observable<Student> {
    console.log("create student");  // test async
    return this._httpClient.post<Student>(this._API_URL_STUDENTS, student);
  }

  update(student: Student, id: number): Observable<Student> {
    console.log("update student");  // test async
    return this._httpClient.put<Student>(`${this._API_URL_STUDENTS}/${id}`, student);
  }

  delete(id: number): Observable<Student> {
    console.log("delete student");  // test async
    return this._httpClient.delete<Student>(`${this._API_URL_STUDENTS}/${id}`);
  }

}
