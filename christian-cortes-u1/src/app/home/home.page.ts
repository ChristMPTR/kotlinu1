import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { CirculoComponent } from '../componentes/circulo/circulo.component';
import { TrianguloComponent } from '../componentes/triangulo/triangulo.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    IonicModule,
    FormsModule,
    CirculoComponent,
    TrianguloComponent,
  ],
  templateUrl: 'home.page.html',
})
export class HomePage {
  figuraSeleccionada: string = '';
}
