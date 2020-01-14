import { Component, OnInit } from '@angular/core';

import { DocumentDTO} from 'src/dto/documentdto';
import { DocumentService} from 'src/service/document.service';

import {FolderDTO} from '../../../dto/folderdto';
import {UserDTO} from '../../../dto/userdto';
import {CategoryDTO} from '../../../dto/categorydto';
import {ExtensionDTO} from '../../../dto/extensiondto';

import {UserService} from '../../../service/user.service';
import {FolderService} from '../../../service/folder.service';
import {CategoryService} from '../../../service/category.service';
import {ExtensionService} from '../../../service/extension.service';
import { stringify } from 'querystring';

@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css']
})
export class DocumentsComponent implements OnInit {

  documents: DocumentDTO[];
  users: UserDTO[];
  folders: FolderDTO[];
  categories: CategoryDTO[];
  extensions: ExtensionDTO[]; 

  
  userdto: UserDTO;
  name: string;

  //guest: UserDTO = new UserDTO();

  documenttoinsert: DocumentDTO = new DocumentDTO();

  constructor(private service: DocumentService, private userService: UserService,
              private folderService: FolderService, private categoryService: CategoryService,
              private extensionService: ExtensionService) { }

  ngOnInit() {
    this.getDocuments();
    this.getUsers();
    this.getFolders();
    this.getCategories();
    this.getExtensions();
  }

  getDocuments() {
    this.service.getAll().subscribe(documents => {
      this.documents = documents
      console.log(documents)
      this.documents.forEach(element => {
        console.log(element)
        //this.name = element.user.username;
        console.log(element.folder);
        this.userdto= element.user;
        console.log(this.userdto);
      });
    });
  }

  getUsers() {
    this.userService.getAll().subscribe(users => this.users = users);
  }

  getFolders() {
    this.folderService.getAll().subscribe(folders => this.folders = folders);
  }

  getCategories() { 
    this.categoryService.getAll().subscribe(categories => this.categories = categories);
  }

  getExtensions() {
    this.extensionService.getAll().subscribe(extensions => this.extensions = extensions);
  }

  delete(document: DocumentDTO) {
    this.service.delete(document.id).subscribe(() => this.getDocuments());
  }

  update(document: DocumentDTO) {
    this.service.update(document).subscribe(() => this.getDocuments());
  }

  insert(document: DocumentDTO) {
    this.service.insert(document).subscribe(() => this.getDocuments());
  }

  clear() {
    this.documenttoinsert = new DocumentDTO();
  }
}
