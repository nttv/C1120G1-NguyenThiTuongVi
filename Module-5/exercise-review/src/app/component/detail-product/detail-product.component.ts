import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute} from '@angular/router';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {DeleteProductComponent} from '../delete-product/delete-product.component';
import {NgForm} from '@angular/forms';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.scss']
})
export class DetailProductComponent implements OnInit {

  product: Product;
  collapsed: boolean = true;

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _matDialog: MatDialog) {
  }

  ngOnInit(): void {
    this._productService.setMessage('');
    this.initData();
  }

  initData() {
    let id = this._activatedRoute.snapshot.params['id'];
    this._productService.getById(id).subscribe(data => {
      this.product = data;
    });
  }

  openModal(id: number) {
    const dialogConfig = new MatDialogConfig();
    // Send data to dialog
    dialogConfig.data = {
      description: 'Do you really want to delete this product?\nThis process cannot be undone.',
      id: id
    };
    const modalDialog = this._matDialog.open(DeleteProductComponent, dialogConfig);
  }

  updateAmount(detailForm: NgForm) {
    if (detailForm.valid) {
      console.log(detailForm.value);
      console.log(typeof detailForm.value);
      // this.product.amount = detailForm.value;
      // this._productService.update(this.product, this.product.id).subscribe();
    }
  }
}
