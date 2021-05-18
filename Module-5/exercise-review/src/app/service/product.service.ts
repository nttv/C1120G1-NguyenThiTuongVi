import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private _API_URL_PRODUCTS = 'http://localhost:3000/products';
  private _API_URL_ORIGINS = 'http://localhost:3000/origins';

  private _message: string = '';
  private _limit_per_page: number = 5;

  constructor(private _httpClient: HttpClient) {
  }

  getMessage() {
    return this._message;
  }

  setMessage(message: string) {
    this._message = message;
  }

  getOrigins(): Observable<string[]> {
    return this._httpClient.get<string[]>(this._API_URL_ORIGINS);
  }

  getAll(): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this._API_URL_PRODUCTS);
  }

  getById(id: number): Observable<Product> {
    return this._httpClient.get<Product>(`${this._API_URL_PRODUCTS}/${id}`);
  }

  save(product: Product): Observable<Product> {
    return this._httpClient.post<Product>(this._API_URL_PRODUCTS, product);
  }

  update(product: Product, id: number): Observable<Product> {
    return this._httpClient.put<Product>(`${this._API_URL_PRODUCTS}/${id}`, product);
  }

  delete(id: number): Observable<Product> {
    return this._httpClient.delete<Product>(`${this._API_URL_PRODUCTS}/${id}`);
  }

  getPage(page: number): Observable<Product[]> {
    return this._httpClient.get<Product[]>(`${this._API_URL_PRODUCTS}?_page=${page}&_limit=${this._limit_per_page}`);
  }

}
