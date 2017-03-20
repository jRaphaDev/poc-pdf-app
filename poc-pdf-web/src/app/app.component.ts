import { Component } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';

  constructor(private appService: AppService) {
  }

  generatePDF() {
    this.appService.generatePDF().subscribe(
      (response) => {
        var fileURL = URL.createObjectURL(response);
        window.open(fileURL);
        }
    )
  }
}
