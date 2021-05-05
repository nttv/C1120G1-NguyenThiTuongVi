import { Component } from '@angular/core';

@Component({
    templateUrl: './word.component.html',
    selector: 'app-word',
    styleUrls: ['./word.component.scss']
})

export class WordComponent {
    en = 'Hello';
    vi = 'Xin chào';
    imgUrl = 'https://angular.io/assets/images/logos/angular/logo-nav@2x.png';
    forgot = false;

    toggleForgot() {
        this.forgot = !this.forgot;
    }
}