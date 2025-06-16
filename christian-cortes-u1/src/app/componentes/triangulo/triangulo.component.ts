import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { TrianguloEscaleno } from '../../modelo/figura';

@Component({
  selector: 'app-triangulo',
  standalone: true,
  imports: [CommonModule, IonicModule, FormsModule],
  templateUrl: './triangulo.component.html',
  styleUrls: ['./triangulo.component.scss'],
})
export class TrianguloComponent {
  ladoA: number = 0;
  ladoB: number = 0;
  ladoC: number = 0;
  resultado: number | null = null;

  calcular() {
    const figura = new TrianguloEscaleno(this.ladoA, this.ladoB, this.ladoC);
    this.resultado = figura.calcularPerimetro();
  }
}
