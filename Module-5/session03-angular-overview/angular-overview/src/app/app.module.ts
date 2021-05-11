import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { PracticeFontSizeEditorComponent } from './practice-font-size-editor/practice-font-size-editor.component';
import { PracticePetComponent } from './practice-pet/practice-pet.component';
import { PracticeProductComponent } from './practice-product/practice-product.component';
import { ExerciseCalculatorComponent } from './exercise-calculator/exercise-calculator.component';
import { ExerciseColorPickerComponent } from './exercise-color-picker/exercise-color-picker.component';

@NgModule({
  declarations: [
    AppComponent,
    PracticeFontSizeEditorComponent,
    PracticePetComponent,
    PracticeProductComponent,
    ExerciseCalculatorComponent,
    ExerciseColorPickerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
