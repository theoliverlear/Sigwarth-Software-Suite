import { Component } from '@angular/core';

@Component({
  selector: 'ss-footer',
  standalone: false,
  templateUrl: './ss-footer.component.html',
  styleUrls: ['./ss-footer.component.scss']
})
export class SsFooterComponent {
    constructor() {
        
    }
    
    getYear(): number {
        return new Date().getFullYear();
    }
}
