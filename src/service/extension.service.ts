import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { ExtensionDTO } from 'src/dto/extensiondto';

@Injectable({
  providedIn: 'root'
})
export class ExtensionService extends AbstractService<ExtensionDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'extension';
  }
}
