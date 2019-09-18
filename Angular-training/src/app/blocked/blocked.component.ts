import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleService } from '../article.service';
import { Article } from '../article';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-blocked',
  templateUrl: './blocked.component.html',
  styleUrls: ['./blocked.component.scss']
})
export class BlockedComponent implements OnInit {
  blockedArticles: Article[];
  statusCode: number;
  requestProcessing = false;
  processValidation = false;


  constructor(private router: Router,private articleService: ArticleService, private httpClient: HttpClient) { }

  ngOnInit(): void {
    if(localStorage.getItem('atcl')==null){
      this.router.navigate(['']);
    }
    this.getBlockedArticles();
  }  
  adminLogout(){
    localStorage.clear();
    this.router.navigate(['']);
  }
  backToAdmin(){
    this.router.navigate(['s1']);
  } 
  //Fetch all articles
  getBlockedArticles() {
       this.articleService.getBlockedArticles()
     .subscribe(
               data => this.blockedArticles = data,
               errorCode =>  this.statusCode = errorCode);   
  }
  unblockArticle(id: string)
  {
  
  const uploadData = new FormData();
  
  uploadData.append('articleId',id);
  
  this.httpClient.post('http://localhost:9087/user/unblock', uploadData)
  .subscribe((data)=> {
  alert("Unblocked successfully.");
  window.location.reload();
  });
  }
//Perform preliminary processing configurations
preProcessConfigurations() {
  this.statusCode = null;
this.requestProcessing = true;   
}
}
