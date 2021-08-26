import { Component } from '@angular/core';
import { ShortenurlService } from './shortenurl.service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'shortenUrlCodeFrontend';

  private DOMAIN: string = "zg.com.br/";

  longUrl: any = "";
  shortenUrl: string = "";
  errorMessage: string = "";

  constructor(private shortenurlService: ShortenurlService) {}
  ngOnInit() {
    this.longUrl = "";
  }

  encurtarUrl() {
    this.shortenurlService.generateShortUrl(this.longUrl).subscribe(
      dados => {
        alert(JSON.stringify(dados));
        this.shortenUrl = this.DOMAIN.concat(dados.codeForUrl)
        this.longUrl = dados.longUrl;
      },
      error => {
        this.errorMessage = `HttpStatus: ${error.status}, Erro ao acessar o recurso de encurtamento de URLs`;
        setInterval(() => {
          this.errorMessage = "";
        }, 5000);
      }
    )
  }
}
