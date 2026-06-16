import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

import { Stream } from './models/stream.model';
import { StreamService } from './services/stream.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  streams: Stream[] = [];
  featuredStream?: Stream;
  loading = true;
  errorMessage = '';

  readonly categories = ['Games', 'Software', 'Arte', 'Musica', 'Just Chatting'];

  constructor(private readonly streamService: StreamService) {}

  ngOnInit(): void {
    this.streamService.getLiveStreams().subscribe({
      next: (streams) => {
        this.streams = streams;
        this.featuredStream = streams[0];
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Nao foi possivel carregar as transmissoes agora.';
        this.loading = false;
      },
    });
  }

  formatViewers(viewerCount: number): string {
    if (viewerCount >= 1000) {
      return `${(viewerCount / 1000).toFixed(1)} mil`;
    }

    return viewerCount.toString();
  }
}
