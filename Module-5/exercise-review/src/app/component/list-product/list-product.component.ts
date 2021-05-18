import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {DeleteProductComponent} from '../delete-product/delete-product.component';
import {Product} from '../../model/Product';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.scss']
})
export class ListProductComponent implements OnInit {

  products: Product[] = [];
  message: any;
  page: number = 1;

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _matDialog: MatDialog) {
  }

  ngOnInit(): void {
    this.initData();
  }

  initData() {
    this.message = this._productService.getMessage();
    let pageParam = this._activatedRoute.snapshot.params['_page'];
    if (pageParam) {
      this.page = pageParam;
    }
    this._productService.getPage(this.page).subscribe(data => {
      this.products = data;
    }, error => {
      console.log('getAll(): ' + error);
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
    modalDialog.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.initData();
      }
    });
  }

  closeAlert() {
    let alert = document.getElementById('alert').style;
    // @ts-ignore
    alert.opacity = 1;
    (function fade() {
      // @ts-ignore
      (alert.opacity -= .1) < 0 ? alert.display = 'none' : setTimeout(fade, 60);
    })();
    this._productService.setMessage('');
  }

}
