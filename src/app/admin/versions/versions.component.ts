import { Component, OnInit } from '@angular/core';
import { VersionDTO } from 'src/dto/versiondto';
import { VersionService } from 'src/service/version.service';


@Component({
  selector: 'app-versions',
  templateUrl: './versions.component.html',
  styleUrls: ['./versions.component.css']
})
export class VersionsComponent implements OnInit {

  versions: VersionDTO[];
  versiontoinsert: VersionDTO = new VersionDTO();

  constructor(private service: VersionService) { }

  ngOnInit() {
    this.getVersions();
  }

  getVersions() {
    this.service.getAll().subscribe(versions => this.versions = versions);
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

  clear(){
    this.versiontoinsert = new VersionDTO();
  }
}
