import { ChangeDetectorRef, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-travels-detail',
  templateUrl: './travels-detail.component.html',
  styleUrls: ['./travels-detail.component.css']
})
export class TravelsDetailComponent implements OnInit {

  constructor(private cd: ChangeDetectorRef) { }

  ngOnInit() {
  }
  ngAfterViewInit() {
    this.cd.detectChanges();
  }

}
