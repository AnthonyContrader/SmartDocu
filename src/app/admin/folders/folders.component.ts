import { Component, OnInit } from '@angular/core';
import { FolderDTO } from 'src/dto/folderdto';
import { FolderService } from 'src/service/folder.service';

@Component({
  selector: 'app-folders',
  templateUrl: './folders.component.html',
  styleUrls: ['./folders.component.css']
})
export class FoldersComponent implements OnInit {

  folders: FolderDTO[];
  foldertoinsert: FolderDTO=  new FolderDTO();

  constructor(private service: FolderService) { }

  ngOnInit() {
    this.getFolders();
  }

  getFolders(){
    this.service.getAll().subscribe(folders => this.folders = folders);
  }
  delete(folder:FolderDTO){
    this.service.delete(folder.id).subscribe(() => this.getFolders());

  }
  update(folder:FolderDTO){
    this.service.update(folder).subscribe(() => this.getFolders());

  }
  insert(folder:FolderDTO){
this.service.insert(folder).subscribe(()=> this.getFolders());

  }
  clear(){
    this.foldertoinsert = new FolderDTO();
  }
  


}
