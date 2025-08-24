# @theoliverlear/styles-suite

A small set of base SCSS functions and mixins for Sigwarth Software UI projects.
Publish-ready for GitHub Packages.

## Features
- Handy layout mixins: `flex`, `size`, `square-size`, `basic-margin-padding`
- Utility functions: `calc-size`, `simple-calc`, `simplest-calc`, `simple-pixel-calc`, `add-alpha`
- Clean entry via `index.scss` using modern Sass `@use`/`@forward`

## Installation
This package is published to GitHub Packages under the `@theoliverlear` scope.

1) Configure your project `.npmrc` to use GitHub Packages for this scope:

```
@theoliverlear:registry=https://npm.pkg.github.com
```

2) Authenticate with a GitHub Personal Access Token (classic) that has `read:packages` (and `write:packages` if you will publish). You can login with:

```
npm login --registry=https://npm.pkg.github.com --scope=@theoliverlear
```

3) Install:

```
npm install @theoliverlear/styles-suite
```

## Usage
Modern Sass usage (recommended) with module system:

```scss
@use "@theoliverlear/styles-suite" as ss;

.container {
  @include ss.flex(space-between, center, row);
  @include ss.size(100%, auto);
}

.button {
  width: ss.calc-size(50, 30, 0.5);
}
```

If you still rely on legacy `@import` (not recommended):

```scss
@import "@theoliverlear/styles-suite/index";
```

## Contents
- `_sigwarth-functions.scss` — common sizing and color functions
- `_sigwarth-mixins.scss` — layout and spacing mixins
- `index.scss` — forwards all modules

## Publishing (maintainers)
This package is configured for GitHub Packages.

- Package name: `@theoliverlear/styles-suite`
- Registry: `https://npm.pkg.github.com`

Steps:
1. Ensure your `.npmrc` (in your user home or repo) contains:
   ```
   @theoliverlear:registry=https://npm.pkg.github.com
   //npm.pkg.github.com/:_authToken=YOUR_GITHUB_TOKEN
   ```
2. From `Npm-Suite/styles-suite`, run:
   ```
   npm version patch   # or minor/major
   npm publish
   ```

## License
ISC © @theoliverlear - Oliver Lear Sigwarth
