# @theoliverlear/angular-suite

A suite of prebuilt Angular components, directives, and services for Sigwarth Software projects.

## Installation

Configure GitHub Packages for the @theoliverlear scope in your .npmrc:

```
@theoliverlear:registry=https://npm.pkg.github.com
```

Then install:

```
npm install @theoliverlear/angular-suite
```

Peer dependencies: Angular v18+, RxJS 7.8+, Zone.js 0.15+.

## Usage

Import the module and use components/directives in your templates:

```ts
import { AngularSuiteModule } from '@theoliverlear/angular-suite';

@NgModule({
  imports: [AngularSuiteModule]
})
export class AppModule {}
```

All components, directives, services, and models are exported via the package public API.

## Building (maintainers)

This library is built with ng-packagr.

```
cd Npm-Suite/angular-suite
npm run build
# publishes from dist
npm publish dist
```

GitHub Actions is configured to build and publish this package to GitHub Packages when triggered.

## License
ISC © @theoliverlear - Oliver Lear Sigwarth
