import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  user_role;

  constructor(
    private router: Router,
    private actRoute: ActivatedRoute
  ) {
  }

  ngOnInit() {
    // nothing to do
  }
  onDataLoaded(event){
    this.user_role = event[0].rolename;
    if(this.user_role == 'admin'){
      this.router.navigate(['../../', 'travels'], { relativeTo: this.actRoute })
    }else{
      this.router.navigate(['../../', 'travels-by-user'], {relativeTo: this.actRoute})
    }
  }

  navigate() {
    this.router.navigate(['../', 'login'], { relativeTo: this.actRoute });
  }

}
