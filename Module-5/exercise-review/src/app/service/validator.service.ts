import {Injectable} from '@angular/core';
import {ProductService} from './product.service';
import {AbstractControl, ValidationErrors} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ValidatorService {

  constructor(private _productService: ProductService) {
  }

  before(control: AbstractControl): ValidationErrors | null {
    let date = new Date(control.value);
    let currentDate = new Date();
    return (date > currentDate) ? {dateBefore: true} : null;
  }

  uniqueId(control: AbstractControl): ValidationErrors | null {
    const id = control.value;
    let check = true;
    this._productService.getById(id).subscribe(data => {
      check = !data;
    });
    return check ? null : {uniqueId: true};
  }

}
