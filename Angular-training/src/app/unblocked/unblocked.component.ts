import { Component, OnInit } from '@angular/core';
import { Article } from '../article';
import { Router } from '@angular/router';
import { ArticleService } from '../article.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-unblocked',
  templateUrl: './unblocked.component.html',
  styleUrls: ['./unblocked.component.scss']
})
export class UnblockedComponent implements OnInit {
  unblockedArticles: Article[];
  statusCode: number;
  requestProcessing = false;

  constructor(private router: Router, private articleService: ArticleService, private httpClient: HttpClient) { }

  ngOnInit(): void {
    if(localStorage.getItem('atcl')==null){
      this.router.navigate(['']);
    }
    this.getUnblockedArticles();
  } 
  adminLogout(){
    localStorage.clear();
    this.router.navigate(['']);
  } 
  backToAdmin(){
    this.router.navigate(['s1']);
  }  
  //Fetch all articles
  getUnblockedArticles() {
       this.articleService.getUnblockedArticles()
     .subscribe(
               data => this.unblockedArticles = data,
               errorCode =>  this.statusCode = errorCode);   
  }
  blockArticle(id: string)
{

const uploadData = new FormData();

uploadData.append('articleId',id);

this.httpClient.post('http://localhost:9087/user/block', uploadData)
.subscribe((data)=> {
alert("Blockeded successfully.");
window.location.reload();
});
}
//Perform preliminary processing configurations
preProcessConfigurations() {
  this.statusCode = null;
this.requestProcessing = true;   

}
}