import {TestBed} from '@angular/core/testing';

import {PactWeb} from "@pact-foundation/pact-web"
import {MedicineService} from './medicine.service';
import {HttpClientModule} from '@angular/common/http';

let provider: PactWeb;

describe('MedicineService', () => {
  let service: MedicineService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
      providers: [MedicineService]
    });
  });

  it('should be created', () => {
    service = TestBed.inject(MedicineService);
    expect(service).toBeTruthy();
  });

  describe('the medicine endpoint', () => {
    beforeAll(done => {
      provider = new PactWeb();

      setTimeout(done, 2000);

      provider.removeInteractions();
    })

    afterAll(() => {
      provider.finalize();
    });

    describe("A get request without an ID", () => {
      beforeAll(() => {
        return provider.addInteraction({
          state: "has 3 medicines",
          uponReceiving: "A get request without an ID",
          withRequest: {
            method: 'GET',
            path: "/api/medicine"
          },
          willRespondWith: {
            status: 200,
            headers: {
              "Content-Type": "application/json"
            },
            body: [
              {
                name: "Paracetamol",
                unit: "strips",
                unitsPerPackage: 3,
                unitForUnit: "Aantal tabletten per strip",
                unitsInUnit: 20
              },
              {
                name: "Ritalin",
                unit: "strips",
                unitsPerPackage: 3,
                unitForUnit: "Aantal tabletten per strip",
                unitsInUnit: 12
              },
              {
                name: "Oogdruppels",
                unit: "flesjes",
                unitsPerPackage: 1,
                unitForUnit: "Aantal milliliter per flesje",
                unitsInUnit: 15
              },
            ]
          }
        })
      })

      it("generates a list of medicines for the medicine selection", (done) => {
        service = TestBed.inject(MedicineService);
        service.getMedicines().subscribe({
          next:(medicines) => {
            expect(medicines).toHaveSize(3);
            medicines.forEach(medicine => expect(medicine.name).toMatch('^[A-z]'));
            done();
          }
        })
      })

      afterEach(() => {
        provider.verify();
      })
    })
  })
});
