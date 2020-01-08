import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { CategoriesComponent } from './categories/categories.component';
import { DocumentsComponent } from './documents/documents.component';
import { ExtensionsComponent } from './extensions/extensions.component';
import { FoldersComponent } from './folders/folders.component';
import { VersionsComponent } from './versions/versions.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'folders', component: FoldersComponent},
    { path: 'documents', component: DocumentsComponent},
    { path: 'categories', component: CategoriesComponent},
    { path: 'versions', component: VersionsComponent},
    { path: 'extensions', component: ExtensionsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
