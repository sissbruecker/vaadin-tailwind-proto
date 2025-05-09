# Vaadin Tailwind CSS prototype

Prototype application for using Tailwind CSS 4 in a Vaadin app.

Configuring Tailwind involved the following steps:
- `npm install tailwindcss @tailwindcss/vite`
- Add `tailwindcss` plugin to Vite config
- Import Tailwind in `styles.css` in theme folder, requires some tweaks to make it work with Lumo
- Configure `vaadin.frontend.hotdeploy = true` in `application.properties`, as the solution uses Vite to compile the CSS

For reference, this commit contains the relevant changes: https://github.com/sissbruecker/vaadin-tailwind-proto/commit/ca192d1d954e4e32478ea0797be7c0266e6a9cdc
