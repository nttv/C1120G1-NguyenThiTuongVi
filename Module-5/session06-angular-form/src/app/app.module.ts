import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PracticeTodoComponent } from './practice-todo/practice-todo.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ExerciseRegisterComponent } from './exercise-register/exercise-register.component';
import { ExerciseLoginComponent } from './exercise-login/exercise-login.component';

@NgModule({
  declarations: [
    AppComponent,
    PracticeTodoComponent,
    ExerciseRegisterComponent,
    ExerciseLoginComponent
  ],
    imports: [
        BrowserModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
