import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { VersionDTO } from 'src/dto/versiondto';

@Injectable({
  providedIn: 'root'
})
export class VersionService extends AbstractService<VersionDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'version';
  }
  
}
