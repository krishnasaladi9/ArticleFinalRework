import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ArticleComponent } from './article.component';
import { AdminComponent } from './admin/admin.component';
import { BlockedComponent } from './blocked/blocked.component';
import { UnblockedComponent } from './unblocked/unblocked.component';
const routes: Routes = [
    {
    path:'',component:ArticleComponent,pathMatch:'full',
    children:[{path:'l1',component:LoginComponent}]
  },

  {
    path:'l1',component:LoginComponent,
  },
  {
    path:'s1',component:AdminComponent
  },
  {
    path:'b1',component:BlockedComponent
  },
  {
    path:'u1',component:UnblockedComponent
  }
]
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }