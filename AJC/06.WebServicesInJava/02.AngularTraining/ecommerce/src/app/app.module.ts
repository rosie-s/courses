import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductComponent } from './product/product.component';
import { SupplierComponent } from './supplier/supplier.component';
import { SupplierListComponent } from './supplier-list/supplier-list.component';
import { DisplayAccountPipe } from './display-account.pipe';
import {FormsModule} from "@angular/forms";
import { ShowPriceDirective } from './show-price.directive';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ProductListComponent,
    ProductComponent,
    SupplierComponent,
    SupplierListComponent,
    DisplayAccountPipe,
    ShowPriceDirective
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
