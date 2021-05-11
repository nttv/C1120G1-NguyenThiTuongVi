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
    new Product('iPhone X', 1000, '01/01/2017', 15, 'US'),
    new Product('Vsmart Aris', 2400, '01/01/2018', 0, 'Vietnam'),
    new Product('Wileyfox Swift 2X ', 1200, '01/01/2019', 6, 'UK'),
    new Product('Xiaomi Redmi Note 10 Pro', 600, '01/01/2017', 10, 'China'),
    new Product('iPhone 8 plus 128GB', 1000, '01/01/2014', 4, 'US'),
    new Product('Oppo F10', 1050, '01/01/2021', 20, 'China'),
  ];

  origins: string[] = ['Vietnam', 'UK', 'US', 'China'];

}
