import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListStudentComponent} from "./student/list-student/list-student.component";
import {EditStudentComponent} from "./student/edit-student/edit-student.component";
import {DeleteStudentComponent} from "./student/delete-student/delete-student.component";
import {CreateStudentComponent} from "./student/create-student/create-student.component";

const routes: Routes = [
  {path: '', component: ListStudentComponent},
  {path: 'create', component: CreateStudentComponent},
  {path: ':id/edit', component: EditStudentComponent},
  {path: ':id/delete', component: DeleteStudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
