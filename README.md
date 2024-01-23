# Mandelbrot Set Visualization

## Overview
Generation and visualization the Mandelbrot set. Allows for interactive exploration of the fractal pattern of the Mandelbrot set through view adjustments.

## Mandelbrot Set Significance

The Mandelbrot set, named after mathematician Benoit Mandelbrot, holds profound significance in mathematics and the broader field of complex systems. It represents a quintessential example of a fractal - an infinitely complex pattern that is self-similar across different scales. Its study has illuminated insights into the behavior of complex systems, chaos theory, and the nature of mathematical iteration.

## Features
- **Complex Number Calculations:** Utilizes the `ComplexNumber` class for handling complex number operations.
- **Interactive Visualization:** Enables users to adjust the view and choose between different color schemes for fractal visualization.
- **Mandelbrot Set Computation:** Implements the mathematical logic for generating the Mandelbrot set.

## How to Run
1. Run `java -jar Driver.jar` to start the application.
2. Interact with the application using the GUI to explore the Mandelbrot set.

## Customization
- Modify the `getColor` method in `MandelbrotTools` to create custom color schemes.
- Adjust the `LIMIT` and `DIVERGENCE_BOUNDARY` in `Controller` for different fractal detail levels.