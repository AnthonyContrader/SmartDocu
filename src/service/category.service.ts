import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { CategoryDTO } from 'src/dto/categorydto';

@Injectable({
  providedIn: 'root'
})
export class CategoryService extends AbstractService<CategoryDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'category';
  }
  
}
