import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PracticeNameCardComponent } from './practice-name-card/practice-name-card.component';
import { PracticeProgressBarComponent } from './practice-progress-bar/practice-progress-bar.component';
import { ExerciseRatingBarComponent } from './exercise-rating-bar/exercise-rating-bar.component';
import { ExerciseCountdownTimerComponent } from './exercise-countdown-timer/exercise-countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    PracticeNameCardComponent,
    PracticeProgressBarComponent,
    ExerciseRatingBarComponent,
    ExerciseCountdownTimerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
