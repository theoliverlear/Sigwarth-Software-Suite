import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'ss-footer',
  standalone: true,
  imports: [CommonModule],
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
