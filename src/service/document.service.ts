import { Injectable } from '@angular/core';
import {AbstractService} from 'src/service/abstractservice'
import {DocumentDTO} from 'src/dto/documentdto'
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocumentService extends AbstractService<DocumentDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'document';
  } 
}

