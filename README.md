# Mandelbrot Set Visualization

## Overview
Generate and visualize the Mandelbrot set. Allows for interactive exploration of the fractal pattern of the Mandelbrot set through view adjustments.

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