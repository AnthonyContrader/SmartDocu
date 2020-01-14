import { Component, OnInit } from '@angular/core';
import { VersionDTO } from 'src/dto/versiondto';
import { VersionService } from 'src/service/version.service';
import {DocumentDTO} from '../../../dto/documentdto';
import {DocumentService} from '../../../service/document.service';


@Component({
  selector: 'app-versions',
  templateUrl: './versions.component.html',
  styleUrls: ['./versions.component.css']
})
export class VersionsComponent implements OnInit {

  versions: VersionDTO[];
  documents: DocumentDTO[];

  versiontoinsert: VersionDTO = new VersionDTO();

  constructor(private service: VersionService, private documentService: DocumentService) { }

  ngOnInit() {
    this.getVersions();
    this.getDocuments();
  }

  getVersions() {
    this.service.getAll().subscribe(versions => this.versions = versions);
  }

  getDocuments() {
    this.documentService.getAll().subscribe(documents => this.documents = documents);
  }

  delete(version: VersionDTO) {
    this.service.delete(version.id).subscribe(() => this.getVersions());
  }

  update(version: VersionDTO) {
    this.service.update(version).subscribe(() => this.getVersions());
  }

  insert(version: VersionDTO) {
    this.service.insert(version).subscribe(() => this.getVersions());
  }

  clear() {
    this.versiontoinsert = new VersionDTO();
  }
}
