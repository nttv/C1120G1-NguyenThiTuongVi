import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ValidatorService} from '../../service/validator.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss']
})
export class CreateProductComponent implements OnInit {

  createForm: FormGroup;
  origins: string[] = [];

  constructor(private _productService: ProductService,
              private _validatorService: ValidatorService,
              private _router: Router,
              private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this._productService.setMessage('');
    this._productService.getOrigins().subscribe(data => {
      this.origins = data;
    }, error => {
      console.log('getOrigins(): ' + error);
    });
    this.initForm();
  }

  initForm() {
    this.createForm = this._formBuilder.group({
      name: ['', Validators.required],
      price: [0, [Validators.required, Validators.min(100000)]],
      productionDate: ['', [Validators.required, this._validatorService.before]],
      amount: [0, [Validators.required, Validators.min(0), Validators.max(100)]],
      origin: ['', Validators.required]
    });
  }

  save() {
    if (this.createForm.valid) {
      this._productService.save(this.createForm.value).subscribe(() => {
        this._productService.setMessage('Added product successfully!!!');
        this._router.navigateByUrl('');
      }, error => {
        console.log('save(): ' + error);
      });
    }
  }

}
