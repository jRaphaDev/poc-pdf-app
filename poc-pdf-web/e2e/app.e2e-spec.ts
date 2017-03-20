import { PocPdfWebPage } from './app.po';

describe('poc-pdf-web App', () => {
  let page: PocPdfWebPage;

  beforeEach(() => {
    page = new PocPdfWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
