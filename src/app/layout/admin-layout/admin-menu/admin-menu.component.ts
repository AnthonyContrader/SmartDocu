import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isCategoryCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isExtensionCollapsed = false;
  isVersionCollapsed = false;
  isDocumentCollapsed = false;
  isFolderCollapsed = false;
  
  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }
 
    categoriescollapse(){
    if (this.isCategoryCollapsed === false)    {
      this.isCategoryCollapsed = true;
    } else { this.isCategoryCollapsed = false;  }
  }
    extensionscollapse(){
      if(this.isExtensionCollapsed === false) {
        this.isExtensionCollapsed = true;
    } else { this.isExtensionCollapsed = false;  }
      }
      folderscollapse(){
        if(this.isFolderCollapsed === false) {
          this.isFolderCollapsed = true;
      } else { this.isFolderCollapsed = false;  }
        }
        versionscollapse(){
          if(this.isVersionCollapsed === false) {
            this.isVersionCollapsed = true;
        } else { this.isVersionCollapsed = false;  }
          }
          documentscollapse(){
            if(this.isDocumentCollapsed === false) {
              this.isDocumentCollapsed = true;
          } else { this.isDocumentCollapsed = false;  }
            }
          
        
      

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }


}
