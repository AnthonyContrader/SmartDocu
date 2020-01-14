import { Component, OnInit } from '@angular/core';
import { ExtensionDTO } from 'src/dto/extensiondto';
import { ExtensionService } from 'src/service/extension.service';

@Component({
  selector: 'app-extensions',
  templateUrl: './extensions.component.html',
  styleUrls: ['./extensions.component.css']
})
export class ExtensionsComponent implements OnInit {

  extensions: ExtensionDTO[];
  extensiontoinsert: ExtensionDTO=  new ExtensionDTO();

  constructor(private service: ExtensionService) { }

  ngOnInit() {
    this.getExtensions();
  }

  getExtensions(){
    this.service.getAll().subscribe(extensions => this.extensions = extensions);
  }
  delete(extension:ExtensionDTO){
    this.service.delete(extension.id).subscribe(() => this.getExtensions());

  }
  update(extension:ExtensionDTO){
    this.service.update(extension).subscribe(() => this.getExtensions());

  }
  insert(extension:ExtensionDTO){
this.service.insert(extension).subscribe(()=> this.getExtensions());

  }
  clear(){
    this.extensiontoinsert = new ExtensionDTO();
  }
  


}
