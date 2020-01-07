import { Component, OnInit } from '@angular/core';
import { DocumentDTO} from 'src/dto/documentdto';
import { DocumentService} from 'src/service/document.service';
  
@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css']
})
export class DocumentsComponent implements OnInit {

  documents: DocumentDTO[];
  documenttoinsert: DocumentDTO = new DocumentDTO();

  constructor(private service: DocumentService) { }

  ngOnInit() {
    this.getDocuments();
  }

  getDocuments() {
    this.service.getAll().subscribe(documents => this.documents = documents);
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

  clear(){
    this.documenttoinsert = new DocumentDTO();
  }
}

