import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ListStudentComponent} from './student/list-student/list-student.component';
import {EditStudentComponent} from './student/edit-student/edit-student.component';
import {DeleteStudentComponent} from './student/delete-student/delete-student.component';
import { CreateStudentComponent } from './student/create-student/create-student.component';

@NgModule({
  declarations: [
    AppComponent,
    ListStudentComponent,
    EditStudentComponent,
    DeleteStudentComponent,
    CreateStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
