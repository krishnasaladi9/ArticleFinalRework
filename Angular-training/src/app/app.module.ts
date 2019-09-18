import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent }  from './app.component';
import { ArticleComponent }  from './article.component';
import { ArticleService } from './article.service';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginService } from './login.service';
import { BlockedComponent } from './blocked/blocked.component';
import { UnblockedComponent } from './unblocked/unblocked.component';

@NgModule({
  imports: [     
        BrowserModule,
            HttpModule,
            HttpClientModule,
            AppRoutingModule,
		ReactiveFormsModule
  ],
  declarations: [
        AppComponent,
		ArticleComponent,
		AdminComponent,
		LoginComponent,
		BlockedComponent,
		UnblockedComponent
  ],
  providers: [
        ArticleService
  ],
  bootstrap: [
        AppComponent
  ]
})
export class AppModule { }
