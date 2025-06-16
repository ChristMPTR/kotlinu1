import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { Circulo } from '../../modelo/figura';

@Component({
  selector: 'app-circulo',
  standalone: true,
  imports: [CommonModule, IonicModule, FormsModule],
  templateUrl: './circulo.component.html',
  styleUrls: ['./circulo.component.scss'],
})
export class CirculoComponent {
  radio: number = 0;
  resultado: number | null = null;

  calcular() {
    const figura = new Circulo(this.radio);
    this.resultado = figura.calcularPerimetro();
  }
}
