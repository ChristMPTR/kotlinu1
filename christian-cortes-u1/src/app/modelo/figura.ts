// src/app/modelos/figura.ts

export class FiguraGeometrica {
  protected nombre: string;

  constructor(nombre: string) {
    this.nombre = nombre;
  }

  calcularPerimetro(): number {
    return 0;
  }
}

export class Circulo extends FiguraGeometrica {
  private radio: number;

  constructor(radio: number) {
    super('Círculo');
    this.radio = radio;
  }

  override calcularPerimetro(): number {
    return 2 * Math.PI * this.radio;
  }
}

export class TrianguloEscaleno extends FiguraGeometrica {
  private ladoA: number;
  private ladoB: number;
  private ladoC: number;

  constructor(ladoA: number, ladoB: number, ladoC: number) {
    super('Triángulo Escaleno');
    this.ladoA = ladoA;
    this.ladoB = ladoB;
    this.ladoC = ladoC;
  }

  override calcularPerimetro(): number {
    return this.ladoA + this.ladoB + this.ladoC;
  }
}
