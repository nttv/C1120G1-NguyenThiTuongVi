import { Component } from '@angular/core';
import { Product } from '../model/Product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'exercise-review';

  products: Product[] = [
    new Product('iPhone X', 1000, '01/01/2017', 35, 'US'),
    new Product('Samsung Note 10', 2400, '01/01/2018', 10, 'Korea'),
    new Product('Dell Vostro 5302 ', 1200, '01/01/2019', 14, 'US'),
    new Product('Acer 5302', 600, '01/01/2017', 20, 'Taiwan'),
    new Product('iPhone 8 plus 128GB', 1000, '01/01/2014', 30, 'US'),
    new Product('Oppo F10', 1050, '01/01/2021', 70, 'China'),
  ];

}
